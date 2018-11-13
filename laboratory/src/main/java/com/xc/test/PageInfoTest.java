package com.xc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.xc.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/spring-mvc.xml"})
public class PageInfoTest {
	// ����SpringMvc��ioc
		@Autowired
		WebApplicationContext context;
		// ����mvc���󣬻�ȡ���������
		MockMvc mockMvc;

		@Before
		public void initMokcMvc(){
		    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		}
		
		@Test
		public void testPage() throws Exception{
			//ģ�������õ�����ֵ
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/labTeachers").param("pn","1"))
			.andReturn();
			
			//����ɹ��Ժ��������л���pageInfo�����ǿ���ȡ��pageInfo������֤
			MockHttpServletRequest request = result.getRequest();
			PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
			System.out.println("��ǰҳ��" + pi.getPageNum());
			System.out.println("��ҳ��" + pi.getPages());
			System.out.println("�ܼ�¼��" + pi.getTotal());
			System.out.println("��ҳ����Ҫ������ʾ��ҳ��");
			int[] nums = pi.getNavigatepageNums();
			for(int i : nums){
				System.out.println(" " + i);
			}
			
			//��ȡԱ������
			List<User> list = pi.getList();
			for(User e : list){
				System.out.println("ID: " + e.getUserId() + "==>Name: " + e.getUsername());
			}
		}
}