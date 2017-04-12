package org.mainacad.core.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mainacad.core.AppConfig;
import org.mainacad.db.register.domain.Stuff;
import org.mainacad.db.register.repositories.StuffCrudRepository;
import org.mainacad.db.register.service.StuffService;
import org.mainacad.db.register.service.StuffServiceImpl;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)

public class StuffServiceImplTest {


    private StuffServiceImpl stuffService;
    private Stuff testStuff;

    @Mock(answer = Answers.RETURNS_MOCKS)
    private StuffCrudRepository mockCrudRepository;

    @Before
    public void setUp() throws Exception {
        stuffService = new StuffServiceImpl();
        stuffService.setStuffCrudRepository(mockCrudRepository);
        testStuff = new Stuff();

    }

    @Test
    public void saveStuff() throws Exception {

        testStuff.setPaymentPurpose("pen");
        stuffService.saveStuff(testStuff);

        verify(mockCrudRepository).save(testStuff);

//        List<Stuff> stuffs =  (List)this.stuffService.listStuff();
//        assertEquals(stuffs.contains(new Stuff().getPaymentPurpose()), "pen");
    }

    @Test
    public void deleteStuff() throws Exception {
        Long id = new Long(1);
        Stuff stuff = stuffService.getStuff(id);
        Assert.assertNotNull("not Null failure", stuff);
        stuffService.deleteStuff(id);
        Stuff deletedStuff = stuffService.getStuff(id);
        Assert.assertNull("expected stuff to be deleted", deletedStuff);

    }

    @Test
    public void getStuff() throws Exception {
        long id = 1L;
        Stuff stuff = new Stuff();
        stuff.setId(id);
        stuffService.saveStuff(stuff);

        Stuff stuffFound = stuffService.getStuff(id);

        Assert.assertNotNull("not null object", stuffFound);
        assertEquals(id, stuffFound.getId());


    }

    @Test
    public void listStuff() throws Exception {

        Long id=new Long(1);
        Long id1=new Long(2);
        Stuff stuff = new Stuff();
        Stuff stuff1 = new Stuff();
        stuff.setPaymentPurpose("pen");
        stuff1.setPaymentPurpose("pencil");

        stuffService.saveStuff(stuff);
        stuffService.saveStuff(stuff1);

        List<Stuff> stuffs =  (List)this.stuffService.listStuff();
        assertTrue(stuffs.contains(new Stuff().getPaymentPurpose().equals("pen")));
        assertTrue(stuffs.contains(new Stuff().getPaymentPurpose().equals("pencil")));


    }

}