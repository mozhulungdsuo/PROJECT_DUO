package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.UserDetails;

public interface FriendDAO {
	public boolean sendFriendRequest(Friend friend);
	public boolean deleteFriendRequest(int friendId);
	public List<UserDetails> showSuggestedFriend(String userName);
	public List<Friend> showAllFriends(String userName);
	public List<Friend> showRequestPendingList(String userName);
	public boolean acceptFriendRequest(int friendId);

}
