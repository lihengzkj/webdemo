package com.siyou.bojun.util;

import java.util.Arrays;
import java.util.UUID;

/**
 * 
 * @author 青山
 * @FileName UUIDGenerator.java
 * @Date Nov 4, 2016
 * @Desc
 *
 */
public class UUIDGenerator {
	
	public static String generateUUID(){ 
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
//		System.out.println(str.length()-4);
		return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
	}
	
	/**
	 * Get a group UUID, length=4
	 * UUID[0]=t_pid
	 * UUID[1]=t_tw_id
	 * UUID[2]=t_us_id
	 * UUID[3]=t_cn_id
	 * @return
	 */
	public static String[] generateGourpUUID(){
		String [] uuids = new String[4];
		for(int i =0;i<uuids.length;i++){
			uuids[i] = UUIDGenerator.generateUUID();
		}
		
		return uuids;
	}
	
	public static void main(String [] args){
//		System.out.println(generateUUID());
		System.out.println(Arrays.toString(UUIDGenerator.generateGourpUUID()));
		/*String str = "bfc013b1-11a9-4f0f-81ed-168ccee1c11a";
		System.out.println(str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24));
		System.out.println("bfc013b111a94f0f81ed168ccee1c11a".length());*/
	}
}
