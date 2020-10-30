package me.jimbae.demoinflearnrestapi.events;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EventTest {

    @Test
    public void builder(){
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean(){
        Event event = new Event();
        String name = "Event";
        event.setName(name);
        String description = "Spring";
        event.setDescription(description);

        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
/*    @Parameters({
            "0, 0, true",
            "100, 0, false",
            "0, 100, false"
    })*/
    /*@Parameters(method = "parametersForTestFree")*/
    @Parameters
    public void testFree(int basePrice, int maxPrice, boolean isFree){
        //Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        //When
        event.update();

        //Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    /**
     * parameterFor* Prefix 사용시 자동으로 가져다 씀
     * @return
     */
    private Object[] parametersForTestFree(){
        return new Object[] {
                new Object[] {0, 0, true},
                new Object[] {100, 0, false},
                new Object[] {0, 100, false},
                new Object[] {100, 200, false}
        };
    }

    @Test
    @Parameters
    public void testOffline(String location, boolean isOffline){
        //Given
        Event event = Event.builder()
                .location(location)
                .build();

        //When
        event.update();

        //Then
        assertThat(event.isOffline()).isEqualTo(isOffline);

    }

    private Object[] parametersForTestOffline(){
        return new Object[]{
                new Object[]{"강남역", true},
                new Object[]{null, false}
        };
    }
}