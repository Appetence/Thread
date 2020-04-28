hashMap     （负载因子）偏移量0.75初始容量15
hashSet     本质是hashMap，放入的是key，value为persent=nrew object();

之所所以为object是因为remove的时候会返回移除的值，如果是null而非object会导致无法判断是否移除成功