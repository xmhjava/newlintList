package com.luban.owner;

public interface PersonBean {
	String getName(); // ȡ���˵�����
    String getGender(); // �Ա�
    String getInterests(); // ��Ȥ
    int getHotOrNotRating(); // HotOrNot���֣�1��10��
 
    void setName(String name);
    void setGender(String name);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);

}
