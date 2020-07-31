package com.example.springhomework;

import com.example.springhomework.Util.BucketUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class SpringHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomeworkApplication.class, args);
        BucketUtil bucketUtil = new BucketUtil();
        BucketUtil.buckets.put("bucket",bucketUtil);
    }

    @Scheduled(fixedRate = 1000)
    public void timer() {
        if (BucketUtil.buckets.containsKey("bucket")){
            //名为：bucket的令牌桶 开始不断生成令牌
            BucketUtil.buckets.get("bucket").incrTokens();
        }
    }

}
