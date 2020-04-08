package com.leyou.item.web;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {
    @Autowired
    SpecificationService specificationService;
    @GetMapping("groups/{cid}")
    @CrossOrigin(origins = "http://localhost:9001")
    public ResponseEntity<List<SpecGroup>> queryGroupById(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(specificationService.queryGroupByCid(cid));
    }
    @GetMapping("params")
    @CrossOrigin(origins = "http://localhost:9001")
    public ResponseEntity<List<SpecParam>> queryParams(@RequestParam("gid")Long gid){
        List<SpecParam>  params = this.specificationService.queryParams(gid);
        if (CollectionUtils.isEmpty(params)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(params);
    }
}
