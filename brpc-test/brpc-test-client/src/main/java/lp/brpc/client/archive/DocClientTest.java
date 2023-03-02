package lp.brpc.client.archive;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.baidu.brpc.spring.annotation.RpcProxy;
import com.google.common.collect.Lists;

/**
 * @author : lvpeng01
 * @since : 2023/2/23
 **/
//@Component
//public class DocClientTest implements ApplicationRunner {
//
//    @RpcProxy
//    private DocumentBusinessService documentBusinessService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        PictureInfoRequest pictureInfoRequest = new PictureInfoRequest();
//        pictureInfoRequest.setPicIds(Lists.newArrayList(6043L));
//        PictureInfoResponse pictures = documentBusinessService.getPictures(pictureInfoRequest);
//        System.out.println(pictures);
//    }
//}
