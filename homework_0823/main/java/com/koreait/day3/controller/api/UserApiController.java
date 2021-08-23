package com.koreait.day3.controller.api;

import com.koreait.day3.ifs.CrudInterface;
import com.koreait.day3.model.network.Header;
import com.koreait.day3.model.network.request.UserApiRequest;
import com.koreait.day3.model.network.response.UserApiResponse;
import com.koreait.day3.service.UserApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    private final UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")    // api/user (post)
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        System.out.println(request);
        return userApiLogicService.create(request);
    }

    /*
        http://127.0.0.1:8080/api/user/21
     */
    @Override
    @GetMapping("{id}") // api/user/{id} (get)
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        return userApiLogicService.read(id);
    }


    /*
{
            "transaction_time":"2021-08-24",
            "resultCode":"OK",
            "description":"OK",
            "data":{
                "id":21,
                "userid":"banana",
                "userpw":"3333",
                "email":"banana@melon.com",
                "hp":"010-2222-2222"
            }
        }
     */
    @Override
    @PutMapping("")     // api/user (put)
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        System.out.println(request);
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")  // api/user/{id}
    public Header<UserApiResponse> delete(@PathVariable(name="id") Long id) {
        return userApiLogicService.delete(id);
    }
}
