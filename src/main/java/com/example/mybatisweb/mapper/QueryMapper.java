package com.example.mybatisweb.mapper;

import com.example.mybatisweb.dto.QueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface QueryMapper {

    List<Map<String,Object>> dynamicQuery(QueryDTO dto);
}
