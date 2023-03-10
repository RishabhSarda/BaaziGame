package com.q3;

public class AccountQ3 implements OnlineAccountQ3, Comparable<AccountQ3> {

	private Integer noOfRegularMovies;
	private Integer noOfExclusiveMovies;
	private String ownerName;
	
	public int monthlyCost() {
		int mCost = 0;
		mCost = basePrice + (noOfRegularMovies*regularMoviePrice) + (noOfExclusiveMovies*exclusiveMoviePrice);
		return mCost;
	}

	public AccountQ3(Integer noOfRegularMovies, Integer noOfExclusiveMovies, String ownerName) {
		super();
		this.noOfRegularMovies = noOfRegularMovies;
		this.noOfExclusiveMovies = noOfExclusiveMovies;
		this.ownerName = ownerName;
	}
	
	@Override
	public String toString() {
		return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD";
	}

	@Override
	public int compareTo(AccountQ3 acc) {
		if(acc.monthlyCost() < this.monthlyCost())
			return 1;
		else if (acc.monthlyCost() == this.monthlyCost())
			return 0;
		else
			return -1;
	}

}
