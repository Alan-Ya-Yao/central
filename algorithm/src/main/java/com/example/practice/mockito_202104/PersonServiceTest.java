//package com.example.practice.mockito_202104;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Matchers.isA;
//import static org.mockito.Mockito.*;
//
///**
// * /**
// *
// * @ClassName: PersonServiceTest
// * @description:
// * @author: pengyi
// * @create: 2021-04-12 15:51
// **/
//public class PersonServiceTest {
//    private PersonDao     mockDao;
//    private PersonService personService;
//
//    @Before
//    public void setUp() throws Exception {
//        //模拟PersonDao对象
//        mockDao = mock(PersonDao.class);
//        when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
//        when(mockDao.update(isA(Person.class))).thenReturn(true);
//
//        personService = new PersonService(mockDao);
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        boolean result = personService.update(1, "new name");
//        assertTrue("must true", result);
//        //验证是否执行过一次getPerson(1)
//        verify(mockDao, times(1)).getPerson(eq(1));
//        //验证是否执行过一次update
//        verify(mockDao, times(1)).update(isA(Person.class));
//    }
//
//    @Test
//    public void testUpdateNotFind() throws Exception {
//        boolean result = personService.update(2, "new name");
//        assertFalse("must false", result);
//        //验证是否执行过一次getPerson(1)
//        verify(mockDao, times(1)).getPerson(eq(2));
//        //验证是否执行过一次update
//        verify(mockDao, never()).update(isA(Person.class));
//    }
//
//}
