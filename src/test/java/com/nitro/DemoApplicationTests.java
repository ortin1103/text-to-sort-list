package com.nitro;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
			StringToSortList stringToSortList;
	String s=("a aa aaa aaaa aaaaa aaaaaa aaaaaaa aaaaaaaa aaaaaaaaa aaaaaaaaaa 1 22 333 4444 55555 666666 7777777 88888888 999999999");
	@Test
	public void testMethodSort() {
		List<String>testCollect= Arrays.asList("999999999","88888888","7777777","666666","aaaaaaaaaa","aaaaaaaaa","aaaaaaaa"
		,"aaaaaaa","aaaaaa");
		assertEquals(testCollect,stringToSortList.collect(s));

	}

}
