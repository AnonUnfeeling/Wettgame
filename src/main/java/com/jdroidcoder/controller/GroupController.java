package com.jdroidcoder.controller;

import com.jdroidcoder.persistent.dto.GroupDto;
import com.jdroidcoder.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@RestController
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/createGroup")
    public ResponseEntity createGroup(@Valid GroupDto groupDto, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        groupService.createGroup(groupDto.getName());
        return ResponseEntity.ok("Group was created");
    }

    @GetMapping("/getAllGroups")
    public ResponseEntity getAllGroups(){
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/deleteGroup")
    public ResponseEntity deleteGroup(@Valid GroupDto groupDto, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        groupService.removeGroup(groupDto.getName());
        return ResponseEntity.ok("Group was removed");
    }

    @GetMapping("/getGroupByName")
    public ResponseEntity getGroupByName(@Valid GroupDto groupDto, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.ok(groupService.getGroupByName(groupDto.getName()));
    }
}
