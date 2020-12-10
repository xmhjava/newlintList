package com.luban.owner;

public interface PersonBean {
	String getName(); // 取得人的名字
    String getGender(); // 性别
    String getInterests(); // 兴趣
    int getHotOrNotRating(); // HotOrNot评分（1到10）
 
    void setName(String name);
    void setGender(String name);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);

}
