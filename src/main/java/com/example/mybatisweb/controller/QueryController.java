package com.example.mybatisweb.controller;

import com.example.mybatisweb.dto.QueryDTO;
import com.example.mybatisweb.mapper.QueryMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@Controller
public class QueryController {


    private final SqlSession session;

    private final QueryMapper queryMapper;

    @GetMapping({"", "main"})
    public String main() {
        return "main";
    }

    @PostMapping("query")
    public String select(QueryDTO dto, Model model) {
        System.out.println(dto.getQuery());
        List<Map<String,Object>> stringObjectMap = queryMapper.dynamicQuery(dto);
        Set<String> strings = stringObjectMap.get(0).keySet();
        System.out.println("strings = " + strings);
        model.addAttribute("result", stringObjectMap);
        return "main";
    }
}
