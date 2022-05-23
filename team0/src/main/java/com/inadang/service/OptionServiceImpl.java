package com.inadang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inadang.domain.OptGroup;
import com.inadang.domain.Option;
import com.inadang.mapper.OptionMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class OptionServiceImpl implements OptionService{

    private final OptionMapper mapper;

    @Override
    public void insert(Option option) {
        mapper.insert(option);
    }

    @Override
    @Transactional
    public void insertGroup(List<OptGroup> optGroups) {
    	for (OptGroup optGroup : optGroups) {
    		mapper.insertGroup(optGroup);
    		for (Option option : optGroup.getOpts()) {
    		option.setGno(optGroup.getGno());
    		mapper.insert(option);
    		}
    	}
    }


	@Override
	public void deleteGroup(Long gno) {
		mapper.deleteGroup(gno);
	}

	@Override
	@Transactional
	public void delete(Long gno) {
		mapper.deleteGroup(gno);
		mapper.delete(gno);
	}
}

