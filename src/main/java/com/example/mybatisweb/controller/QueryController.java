package com.example.mybatisweb.controller;

import com.example.mybatisweb.dto.QueryDTO;
import com.example.mybatisweb.mapper.QueryMapper;
import com.example.mybatisweb.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@RequiredArgsConstructor
@Controller
public class QueryController {


    private final SqlSession session;

    private final QueryMapper queryMapper;

    private final QueryRepository queryRepository;

    @GetMapping({"", "main"})
    public String main() {
        return "main";
    }

    @PostMapping("query")
    public String select(String query, Model model) {
        System.out.println(query);
//        List<Map<String,Object>> stringObjectMap = queryMapper.dynamicQuery(dto);
        List<Map<String, Object>> stringObjectMap = queryRepository.getQuery(query);

        List<String> keyListOfQueryMap = new ArrayList<>(stringObjectMap.get(0).keySet());

        model.addAttribute("keys", keyListOfQueryMap);
        model.addAttribute("result", stringObjectMap);
        return "main";
    }
}
