package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Search;
import mapper.commonMapper;
import myException.MyException;
import service.CommonService;
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private commonMapper comMapper;
	
	@Override
	public void addSearchHistory(int uid,String word) throws MyException {
		Search sh = new Search();
		sh.setUid(uid);
		sh.setWord(word);
		sh.setWordtime(new Date());
		comMapper.insertSearch(sh);
	}
	
	@Override
	public List<String> getSearchHistory(int uid) throws MyException{
		return comMapper.selectWordByWordtime(uid);
	}
	
	@Override
	public void clearHistory(int uid) throws MyException {
		comMapper.deleteSearchByUid(uid);
	}

}
