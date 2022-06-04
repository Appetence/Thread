package jvm.loader;

import learn.util.DateUtil;
import sun.awt.HKSCS;
import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-11 14:15
 */
public class JVMClassLoader {
    public static void main(String[] args) {

        /**
         *  BootStrap ClassLoader加载rt.jar下的文件
         *  在java中runtime.jar包里的类都是引导类加载器（bootstrap class loader）加载的，这个加载器由于是C++写的，所以在java中会为null
         *
         *
         *  lodaing(类加载，用户可以通过自定义的类加载器参与)
         *         通过包名+类名获取class文件，读取
         *         将读取的二进制文件结构化存储到method(方法区，1。8以后叫metaSpeace 元区域)，只是转化了数据结构，并未合并数据
         *         内存中生成一个class对象，作为这个类各种数据访问的入口，这个Class对象并没有规定是在Java堆内存中，它比较特殊，虽为对象，但存放在方法区中
         *  linking（将二进制对象合入jre中）
         *          验证：校验加载后数据结构是否正确，是否符合jvm规范
         *          准备：为静态变量在虚拟机中分配内存，并赋初始值，
         *               静态常量（static final int a = 6）会在准备阶段赋予初始值，静态变量会在初始化时候赋予初始值
         *               一般成员变量在类初始化时候随对象分配到堆内存中
         *          解析：将二进制数据中的符号引用转成直接引用
         *               将类、方法、属性等符号引用解析为直接引用,即直接可以访问到的内容
         *               常量池中的各种符号引用解析为指针、偏移量等内存地址的直接引用
         *               符号引用: 符号引用以一组符号来描述所引用的目标。符号引用可以是任何形式的字面量，只要使用时能无歧义地定位到目标即可。个人理解为：在编译的时候一个每个java类都会被编译成一个class文件，但在编译的时候虚拟机并不知道所引用类的地址，所以就用符号引用来代替，而在resolution阶段就是为了把这个符号引用转化成为真正的地址的阶段。
         *               直接引用:直接引用就是真正的内存地址值，即 直接指向目标的指针、偏移量等内存地址形式
         *  initialization(类初始化，真正执行Java代码)
         *          静态变量赋予程序设定的初始值（如static int a = 100;在准备阶段，a被赋默认值0，在初始化阶段就会被赋值为100）
         *
         *          Java虚拟机规范中严格规定了有且只有五种情况必须对类进行初始化
         *              主动引用：
         *                      1、使用new字节码指令创建类的实例，或者使用getstatic、putstatic读取或设置一个静态字段的值（放入常量池中的常量除外），或者调用一个静态方法的时候，对应类必须进行过初始化。
         *                      2、通过java.lang.reflect包的方法对类进行反射调用的时候，如果类没有进行过初始化，则要首先进行初始化。
         *                      3、当初始化一个类的时候，如果发现其父类没有进行过初始化，则首先触发父类初始化。
         *                      4、当虚拟机启动时，用户需要指定一个主类（包含main()方法的类），虚拟机会首先初始化这个类。
         *                      5、使用jdk1.7的动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getStatic、REF_putStatic、RE_invokeStatic的方法句柄，并且这个方法句柄对应的类没有进行初始化，则需要先触发其初始化。
         *              被动引用
         *                      其他情况
         */

        /**
         * 对象内存布局
         * 1 对象创建过程
         *     1 class loading  类加载到内存
         *     2 class linking
         *         1 verification   校验是否符合class文件规范
         *         2 preparation    准备，final 修饰的变量赋予初始值
         *         3 resolution     解释 将二进制数据中的符号引用转成直接引用
         *     3 class initialization   static静态变量赋予程序设定的初始值
         *     4 申请对象开辟内存空间
         *     5 成员变量赋予默认值
         *     6 调用构造方法（init）
         *         成员变量赋初始值
         *         构造方法执行语句
         */
        /**
         * jvm 内存区域划分
         *  方法区 metaSpeace      也叫元区域
         *      JDK1.8之前叫做方法区(永久代); 在JDK1.8之后，方法区被废弃，改成了基于本地内存 (Native Memory)存储的 Metaspace ，我们可以理解成元数据区，
         *      它是一块线程共享的内存区域。主要用来保存被JVM加载的类的信息、常量、静态变量以及即时编译器(JIT)编译后的代码等数据
         *      注意:严格意义来讲metaspace并不在虚拟机中，而是使用本地物理内存。
         *  本地方法区   local method
         *      对于一个运行中的Java程序而言，它还可能会用到一些跟本地方法相关的数据区。当某一个线程调用本地方法时，便进入了一个全新的不受虚拟机控制的全新的世界，它和虚拟机拥有同样权限。因为他进入了C的运行。本地方法甚至可以访问运行时数据区，直接使用CPU的寄存器。
         *      本地方法栈服务的对象是JVM执行的native方法，而虚拟机栈服务的是JVM执行的java方法。如何去服务native方法？native方法使用什么语言实现？怎么组织像栈帧这种为了服务方法的数据结构？虚拟机规范并未给出强制规定，因此不同的虚拟机可以进行自由实现，
         *      我们常用的HotSpot虚拟机选择合并了虚拟机栈和本地方法栈。
         *      综合上述讲解，我们可以得出JVM的内存结构的图示:
         *      https://blog.csdn.net/weixin_39884877/article/details/111262264
         *  程序计数器 program counter register        每个线程独享
         *      记录字节码执行到哪一行
         *  堆  heap
         *      Java堆内存是用于存放由new创建的对象和数组，是java虚拟机所管理的内存中最大的一块，它里面的数据是所有线程共享的所以堆中的对象需要考虑线程安全性问题，它也是是垃圾收集器管理的主要区域。
         *      堆内存空间分为，新生代（1/3），老年代（2/3）
         *      新生代
         *          新new 出来的对象存储于新生代，一般占用虚拟机内存1/3 ，由于频繁创建对象，新生代会频繁触发minorGC
         *          新生代分为 eden区 和 survivor区域，surviver区域又分为surviverFrom和surviverTo区域，他所占比例分别为    8:1:1
         *              eden: 新创建对象存放区域（如果新创建对象所占内存较大，直接放到老年代中），当eden的内存不够时，会触发minorGc
         *              surviverFrom: 上一次gc 时存活下来的对象，这一次minorGc被扫描对象
         *              surviverTo: gc后存活对象存放区域
         *                  按照对象的年龄排序的话，应该是 Survivor To区 > Survivor From区 > Eden区
         *         但是每次MinorGC完之后，Survivor To区的内容又会变成Survivor From区的内容，成为下一次MinorGC被扫描者。在发生MinorGC时，Eden区和Survival From区会把一些仍然存活的对象复制进Survival To区，并清除自身内存。Survival To区会把一些存活得足够旧的对象移至年老代。
         *      老年代
         *          新生代经过多次minorGc后仍存活的对象会被移入老年代中，所以老年代的对象比较稳定，不会频繁进行majorGc；在执行majorGc前会先进行一次minorGc，将新生代的对象有机会进入到老年代中，
         *          当老年代空间不足时会进行MajoryGc进行空间清理，如果清理后仍然没有足够的空间来对象存储，会抛出oom（Out of memory）异常
         *      小结：对象创建后会先存储在新生代，当一个对象太大时候，会直接创建出来，存储到老年代中；新生代中频繁进行minorGc，创建出来的对象也会经常销毁，当一个对象经过多次minorGc后会移动到老年代中存储
         *      永久代
         *          首先声明: 永久代不是堆内存中的。永久代是指内存的永久保存区域 ，主要存放类、常量、静态成员等相关信息。Class在被加载的时候被放入永久区域。它和和存放实例的区域不同，GC不会在主程序运行期对永久区域进行清理。所以这也导致了永久代的区域会随着加载的Class的增多而胀满，最终抛出OOM异常。
         *          在jdk1.8中，永久代已经被移除了，取而代之的是MetaSpace(元数据区)，本质和永久代类似，都是对JVM规范中方法区的实现，区别在于元数据区并不在虚拟机中，而是使用本地物理内存，永久代在虚拟机中。
         *          另外关于常量池，jdk1.6及之前常量池是在永久代中，jdk1.7虽然还有永久代，但是常量池已经被放到了堆内存中，jdk1.8已经去除了永久代，常量池放在MetaSpace中。
         *
         *  栈 stack     每个线程独享
         *      单独存储线程中的局部变量等数据，由于Java虚拟机栈是线程独享的内存空间，所以每一个线程都有自己的栈内存空间。
         *      每一个方法在栈内存中执行的时候，都会在栈内存中创建一个自己的栈帧，每一个栈帧里会存储该方法执行时候的数据，每一个栈帧都包含局部变量表、操作数栈、动态链接、方法出口等。
         *      每一个方法从调用开始至执行完成的过程，都对应着一个栈帧在虚拟机里面从入栈到出栈的过程。在活动线程中，只有位于栈顶的栈帧才是有效的，称为当前栈帧，与这个栈帧相关联的方法称为当前方法。
         *          局部变量
         *              栈内存中我们主要关注的是局部变量表，所以局部变量表在栈内存中的地位是举足轻重的。局部变量表是一组变量存储空间，用于存放方法参数和方法内部定义的局部变量。并且在Java编译为Class文件时，就已经确定了该方法所需要分配的局部变量表的最大容量。
         *              局部变量表的容量是以变量槽作为最小单位的，每个变量槽可存储32位长度的数据。在局部变量表中，会存储基本数据类型和引用( reference)数据类型的变量，对于 reference 虚拟机会从直接或者间接引用中找到对象的以下两点:
         *                  1 堆内存中对象存储的地址索引
         *                  2 所属数据类型在MetaSpace中存储的数据类型
         *              而对于基本数据类型的变量，它的值会直接存储在局部变量表中，而我们前面说了局部变量表中的最小单位变量槽最大可存储长度为32位，那么我们先回顾一下各个基本数据类型的长度：
         *                  对于长度小于等于32位的数据，一个变量槽完全可以存储，但是对于长度为64位的long、double类型，一个变量槽完全无能为力，那么此时怎么办呢？此时虚拟机会以高位对齐方式为其分配两个连续的变量槽空间，也就是相当于把一次long和double数据类型读写分割成为两次32位读写。
         *                  为了尽可能节省栈帧空间，局部变量表中的变量槽是可以复用的，但这样也会有缺点:  影响到系统的垃圾收集行为,比如某个大方法占用较多的Slot，执行完该方法的作用域后没有对Slot赋值或者清空设置null值，垃圾回收器便不能及时的回收该内存。
         *          操作数栈
         *              Java虚拟机的解释执行引擎被称为"基于栈的执行引擎"， －操作数栈。操作数栈是通过标准的栈操作—压栈和出栈来访问的，比如某个指令将一个数据压栈到操作数栈中，
         *              那么下一个指令就可以通过出栈操作从操作数栈中获取数据并且使用虚拟机把操作数栈作为它的工作区——大多数指令都要从这里弹出数据，执行运算，然后把结果压回操作数栈。
         *          动态连接
         *              静态连接：classLiking时候会将类，方法，属性的引用由符号引用改为直接引用，也就是将常量池中的符号引用解析为指针，偏移量等内存地址的直接引用
         *              动态连接：每一个栈帧内部都包含有一个指向运行时常量池中该方法的引用，包含这个引用的主要目的是为了支持当前方法的代码能够实现动态链接（dynamic linking）；这些动态连接的作用是将符号引用转为直接引用
         *                       在Java源文件被编译到字节码文件中时，所有的变量和方法引用都作为符号引用(Symbolic Reference)保存在class文件的常量池。
         *                       方法，属性引用的时候都会转成动态链接；
         *          方法出口
         *              记录执行时候从方法被调用的位置，当一个方法执行后有两种情况可以返回：
         *                  1 方法返回指令：当字节码执行引擎遇到return指令时候，会返回上层方法调用者，以这种方式退出方法
         *                  2 当程序执行过程中遇到异常 throw Exception，但是并没有处理这个异常时候会导致方法退出
         *
         */
        //null
        System.out.println(String.class.getClassLoader());
        //appclassLoader
        System.out.println(DateUtil.class.getClassLoader());
        //null
        System.out.println(HKSCS.class.getClassLoader());
        //EXtClassLoader
        System.out.println(DNSNameService.class.getClassLoader());
        //null  bootstrap
        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());

    }
}