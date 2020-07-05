package cn.qixqi.vote.proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cn.qixqi.vote.entity.Option;
import cn.qixqi.vote.entity.LoginLog;
import cn.qixqi.vote.entity.User;
import cn.qixqi.vote.entity.Vote;
import cn.qixqi.vote.entity.VoteLog;

public class ProxyVisitor implements Visitor{
	private int priority;
	private RealVisitor realVisitor = new RealVisitor();
	
	public ProxyVisitor(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String userRegister(User user) {
		if (priority == Priorities.VISITOR) {
			// 游客注册
			return realVisitor.userRegister(user);
		} else {
			return "已有账号，且已登录";
		}
	}

	@Override
	public User userLogin(String key, String password) {
		// TODO Auto-generated method stub
		if (priority == Priorities.VISITOR) {
			return realVisitor.userLogin(key, password);
		} else {
			// 已经登录
			return null;
		}
	}

	@Override
	public String userLogout(int userId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.userLogout(userId);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public String updateAvatar(int userId, String userAvatar) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.updateAvatar(userId, userAvatar);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public String getUserAvatar(int userId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.getUserAvatar(userId);
		} else {
			return null;
		}
	}

	@Override
	public String updateUserInfo(int userId, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.updateUserInfo(userId, map);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public String resetPass(int userId, String userPassword) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.resetPass(userId, userPassword);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public String publishVote(int userId, Vote vote) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.publishVote(userId, vote);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public String deleteVote(int voteId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.deleteVote(voteId);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public Vote getVote(int voteId) {
		// TODO Auto-generated method stub
		return realVisitor.getVote(voteId);
	}

	@Override
	public List<Vote> getVotes(int userId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.getVotes(userId);
		} else {
			return null;
		}
	}

	@Override
	public String addOption(int optionType, int voteId, Option option) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.addOption(optionType, voteId, option);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public Option getOption(int optionType, int optionId) {
		// TODO Auto-generated method stub
		return realVisitor.getOption(optionType, optionId);
	}

	@Override
	public List<Option> getOptions(int optionType, int voteId) {
		// TODO Auto-generated method stub
		return realVisitor.getOptions(optionType, voteId);
	}

	@Override
	public String addPoll(int optionType, int optionId) {
		// TODO Auto-generated method stub
		return realVisitor.addPoll(optionType, optionId);
	}

	@Override
	public String deleteOption(int optionType, int optionId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.deleteOption(optionType, optionId);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public String updateOption(int optionType, int optionId, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.updateOption(optionType, optionId, map);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public String addLoginLog(LoginLog log) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.addLoginLog(log);
		} else {
			return "您还未登录";
		}
	}

	@Override
	public LoginLog lastLoginLog(int userId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.lastLoginLog(userId);
		} else {
			return null;
		}
	}

	@Override
	public List<LoginLog> getLoginLogs(int userId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.getLoginLogs(userId);
		} else {
			return null;
		}
	}

	@Override
	public String addVoteLog(VoteLog voteLog) {
		// TODO Auto-generated method stub
		return realVisitor.addVoteLog(voteLog);
	}

	@Override
	public Date lastVoteTime(int voteId, String voteIp) {
		// TODO Auto-generated method stub
		return realVisitor.lastVoteTime(voteId, voteIp);
	}

	@Override
	public List<VoteLog> getVoteLogsByVote(int voteId) {
		// TODO Auto-generated method stub
		return realVisitor.getVoteLogsByVote(voteId);
	}

	@Override
	public List<VoteLog> getVoteLogsByUser(int userId) {
		// TODO Auto-generated method stub
		if (priority != Priorities.VISITOR) {
			return realVisitor.getVoteLogsByUser(userId);
		} else {
			return null;
		}
	}
}
