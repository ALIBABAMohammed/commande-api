package com.learning.code.spring_boot_first_fake_app.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//the benefit of using FeignClient is for example we want
// to get some infos or data from other servers (the microservices principal)
@FeignClient(value = "jsonplaceholder", url = "https://jsonplaceholder.typecode.com/")
public interface JSONPlaceHolderClient {

    @GetMapping("posts")
    List<Post> getposts();
    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable Integer postId);
}
