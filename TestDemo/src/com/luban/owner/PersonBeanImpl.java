package com.luban.owner;

public class PersonBeanImpl implements PersonBean{
	    String name;
	    String gender;
	    String interests;
	    int rating; //当前的评价分数
	    int ratingCount = 0; // 当前的评价数
	 
	    @Override
	    public String getName() {
	    	System.out.println(111);
	        return name;
	    }
	 
	    @Override
	    public String getGender() {
	    	System.out.println(222);
	        return gender;
	    }
	 
	    @Override
	    public String getInterests() {
	    	System.out.println(333);
	        return interests;
	    }
	 
	    @Override
	    public int getHotOrNotRating() {
	    	System.out.println(444);
	        if (ratingCount == 0) return 0;
	        return (rating/ratingCount);
	    }
	 
	    @Override
	    public void setName(String name) {
	    	System.out.println(555);
	        this.name = name;
	    }
	 
	    @Override
	    public void setGender(String name) {
	    	System.out.println(666);
	        this.gender = gender;
	    }
	 
	    @Override
	    public void setInterests(String interests) {
	    	System.out.println(777);
	        this.interests = interests;
	    }
	 
	    @Override
	    public void setHotOrNotRating(int rating) {
	    	System.out.println(888);
	        this.rating += rating;
	        ratingCount++;
	    }

	
}
