package com.rbs.irs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rbs.irs.entities.Trader;
import com.rbs.irs.helpers.OracleHelper;

public class LoginManager{
	        private Connection conn;
	        private CallableStatement calstat;
	        private ResultSet resultset;
	        
			public String LoginValidation(Trader trader)
			{
				String tradername=null;
				conn=OracleHelper.getConnection();
				//String query="Select tradername from trader where traderid=? and password=?";
				String getTradersql="(call Login Validation(?,?,?)";
				try
				{
				/*	pre=conn.prepareStatement(query);
					pre.setInt(1, trader.getTraderId());
					pre.setString(2, trader.getPassword());
					
					resultset=pre.executeQuery();
					while(resultset.next())
						tradername=resultset.getString(1);*/
					calstat=conn.prepareCall(getTradersql);
					calstat.setInt(1, trader.getTraderId());
					calstat.setString(2, trader.getPassword());
					calstat.registerOutParameter(3, java.sql.Types.VARCHAR);
					calstat.executeUpdate();
					tradername=calstat.getString(3);
					
				}catch (SQLException e){
					tradername="no Data";
					System.out.println(e.getMessage());
				}
				return tradername;
			}
	
	
}
