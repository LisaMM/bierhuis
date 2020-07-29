package be.vdab.web;

import be.vdab.entities.Brouwer;
import be.vdab.services.*;
import be.vdab.valueobjects.Adres;
import java.math.BigDecimal;
import java.util.Collections;
import org.junit.*;
import org.mockito.Mockito;

/**
 *
 * @author dev13
 */
public class BrouwerControllerTest {
    private BrouwerController brouwerController;
    private Iterable<Brouwer> brouwers;
    private Brouwer brouwer;

    @Before
    public void setUp() {
        brouwers = Collections.emptyList();
        BrouwerService brouwerService = Mockito.mock(BrouwerService.class);
        BierService bierService = Mockito.mock(BierService.class);
        Mockito.when(brouwerService.findAll()).thenReturn(brouwers);
        brouwerController = new BrouwerController(brouwerService, bierService);
        brouwer = new Brouwer("naam1", new Adres("straat1", "huisnr1", 1, 
            "gemeente1"), BigDecimal.ONE);
        Mockito.when(brouwerService.read(1L)).thenReturn(brouwer);
    }

    @Test
    public void findAllActiveertJuisteView() {
        Assert.assertEquals("brouwers/brouwers", brouwerController.findAll()
            .getViewName());
    }
    
    @Test
    public void findAllMaakRequestAttribuutFilialen() {
        Assert.assertSame(brouwers,
        brouwerController.findAll().getModelMap().get("brouwers")); 
    }
    
    @Test
    public void readActiveertJuisteView() {
        Assert.assertEquals("brouwers/brouwer", brouwerController.read(1L)
            .getViewName());
    }
    
    @Test
    public void readMetBestaandeIDGeeftBrouwerTerug() {
    Assert.assertSame(brouwer,
        brouwerController.read(1L).getModelMap().get("brouwer"));
    }
    
    @Test
    public void readMetOnbestaandeIDGeeftNullTerug() {
        Assert.assertNull(
            brouwerController.read(666L).getModelMap().get("brouwer"));
    }
}
