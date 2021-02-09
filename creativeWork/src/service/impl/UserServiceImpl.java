package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Reader;
import bean.User;
import bean.UserActive;
import mapper.UserMapper;
import myException.MyException;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void registerUser(User user)throws MyException{
		userMapper.insertUser(user);
	}
	
	@Override
	public User loginUser(User user)throws MyException{
		return userMapper.selectUserByUAP(user);
	}
	
	@Override
	public void updateUserInfo(User user)throws MyException{
		userMapper.updateUserInfo(user);		
	}
	
	@Override
	public void updateUserLasttime(User user)throws MyException{
		//建立用户活跃时间模型
		UserActive ua = new UserActive();
		ua.setUid(user.getUid());
		ua.setUsername(user.getUsername());
		ua.setLastTime(new Date());
		//查询用户是否存在
		int uid = userMapper.selectUserActiveById(ua.getUid());
		if(uid == 0) {
			userMapper.insertUserActive(ua);
		}else {
			userMapper.updateUserActive(ua);
		}
	}
	
	@Override
	public List<UserActive> findUsersByLasttime()throws MyException{
		return userMapper.selectUserActiveBylasttime();
	}
	
	@Override
	public User findOtherUser(int uid)throws MyException{
		return userMapper.selectUserInfo(uid);
	}
	
	@Override
	public void followAuthor(User user,int uid)throws MyException{
		//建立读者关系
		Reader reader = new Reader();
		reader.setUid(uid);
		reader.setRid(user.getUid());
		reader.setReadername(user.getUsername());
		//查询所有关注的作者
		List<Integer> uids = userMapper.selectFollowByRid(reader.getRid());
		boolean isFollow = false;
		for (Integer integer : uids) {
			//判断是否已关注
			if(reader.getUid() == (int)integer) {
				isFollow = true;
			}
		}
		//未关注时实现关注
		if(!isFollow) {
			userMapper.insertReader(reader);
			//当前用户的关注人数+1
			userMapper.addFollowNum(reader.getRid());
			//该作者的读者人数+1
			userMapper.addReaderNum(reader.getUid());
		}
	}
	
	@Override
	public boolean findIsFollow(int rid, int uid)throws MyException{
		List<Integer> uids = userMapper.selectFollowByRid(rid);
		for (Integer integer : uids) {
			if(uid == (int)integer) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void cancelFollow(User user,int uid)throws MyException{
		//建立关系
		Reader reader = new Reader();
		reader.setUid(uid);
		reader.setRid(user.getUid());
		reader.setReadername(user.getUsername());
		//取消关注
		userMapper.deleteReaderById(reader);
		//当前用户的关注人数-1
		userMapper.lessFollowNum(reader.getRid());
		//该作者的读者人数-1
		userMapper.lessReaderNum(reader.getUid());
	}
	
	@Override
	public List<User> findAllReader(int uid)throws MyException{
		 return userMapper.selectReaderByUid(uid);
	}
	
	@Override
	public List<User> findAllAuthor(int uid)throws MyException{
		return userMapper.selectFollowByUid(uid);
	}
	
	@Override
	public List<User> findUserByWord(String word)throws MyException{
		return userMapper.selectUserByUsername(word);
	}
	
}
