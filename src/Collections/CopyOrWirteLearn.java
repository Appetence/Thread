package Collections;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 写时复制
 *
 * 在向容器中添加一个元素时，不直接添加而是先把元素复制一份出来然后在新的位置进行添加，
 * 添加成功后将元素的引用指向新的位置，实现读写分离
 */
public class CopyOrWirteLearn {
    /**
     * 高并发情况下为了保证数据的一致性可以用如下方法解决
     * Vector
     * Collections.synchronizedList(new ArrayList<>());
     * ConcurrentHashMap
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //CopyOnWriteArraySet arrayList = new CopyOnWriteArraySet( );
        ArrayList arrayList = new ArrayList();

        /**
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836]
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836, 7f5acb2b-737a-476b-8e3d-718369fa8e7d, 60ad8972-2c06-4f74-918e-85203ec8e648, b3ecbb3d-67c1-4a7d-9c92-30c0beeb8e41, bafabd23-5e08-4ef7-b8ef-5f7e447a8c7e, 50d8dd39-5697-4940-b46f-a66d8c46a19d]
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836, 7f5acb2b-737a-476b-8e3d-718369fa8e7d, 60ad8972-2c06-4f74-918e-85203ec8e648, b3ecbb3d-67c1-4a7d-9c92-30c0beeb8e41, bafabd23-5e08-4ef7-b8ef-5f7e447a8c7e, 50d8dd39-5697-4940-b46f-a66d8c46a19d, 321e2137-2c83-435e-a971-63ffa020faaa, 40ffca92-b56b-4ae3-acc9-44bf271bf477]
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836, 7f5acb2b-737a-476b-8e3d-718369fa8e7d, 60ad8972-2c06-4f74-918e-85203ec8e648, b3ecbb3d-67c1-4a7d-9c92-30c0beeb8e41, bafabd23-5e08-4ef7-b8ef-5f7e447a8c7e]
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836, 7f5acb2b-737a-476b-8e3d-718369fa8e7d, 60ad8972-2c06-4f74-918e-85203ec8e648, b3ecbb3d-67c1-4a7d-9c92-30c0beeb8e41]
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836, 7f5acb2b-737a-476b-8e3d-718369fa8e7d, 60ad8972-2c06-4f74-918e-85203ec8e648]
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836, 7f5acb2b-737a-476b-8e3d-718369fa8e7d]
         * [34bae4d7-a1ec-4bf7-a0b8-1eac4371ce84, becfacb7-488b-45d9-8d8f-22c60b2d0a8a, a0e598f4-7557-4b77-90a7-daeab64a4836]
         */
        for (int i = 0; i <4 ; i++) {
            executorService.submit(()->{
                arrayList.add(UUID.randomUUID().toString());
                System.out.println(arrayList);

            });
        }
        executorService.shutdown();
    }



}
