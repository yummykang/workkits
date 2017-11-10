package me.yummykang;

import me.yummykang.entity.tables.CheckIn;
import me.yummykang.entity.tables.records.CheckInRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkkitsApplicationTests {

	@Autowired
	private DSLContext dsl;

	@Test
	@Transactional
	public void contextLoads() {
		CheckIn checkIn = CheckIn.CHECK_IN;
		CheckInRecord checkInRecord = checkIn.newRecord();
		checkInRecord.setCheckInTime(new Date(System.currentTimeMillis()));
		checkInRecord.setCheckOutTime(new Date(System.currentTimeMillis()));
		dsl.insertInto(checkIn).set(checkInRecord).execute();
		Result<CheckInRecord> result = dsl.selectFrom(checkIn).fetch();
//		Result<Record3<Integer, Date, Date>> result = dsl.select(checkIn.ID, checkIn.CHECK_IN_TIME, checkIn.CHECK_OUT_TIME).from(checkIn).fetch();
		System.out.println(result.get(0).getCheckInTime());
//		throw new RuntimeException("故意报错");
	}

}
