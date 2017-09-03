package com.gaurav.accountInfo;

import javax.ejb.PostActivate;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.gaurav.Interceptor.SimpleInterceptor;

/**
 * Session Bean implementation class AccountStatelessBean
 */

@Stateless(mappedName="Account")
@Interceptors(SimpleInterceptor.class)
public class AccountStatefulBean implements AccountStatefulBeanRemote, AccountStatefulBeanLocal {

	public int total=1000;
	
	@PostActivate
	public void name()
	{
		System.out.println("@PostActivate : " + total);
	}
    public AccountStatefulBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void deposit(int amt) {
		total=total+amt;
		System.out.println("Total balance after deposit : " + total);
		
	}

	@Override
	public int withdraw(int amt) {
		total=total-amt;
		System.out.println("Total balance after withdrawal : " + total);
		return total;
	}

	@Override
	public int getBalance() {
		System.out.println("Total available balance : " + total);
		return total;
	}

}
