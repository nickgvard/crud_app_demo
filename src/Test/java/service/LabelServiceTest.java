package service;

import model.entity.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import repository.LabelRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author Nikita Gvardeev 02.11.2021
 * email gvardeev@po-korf.ru
 */
@RunWith(MockitoJUnitRunner.class)
public class LabelServiceTest {

    @Mock
    private Label label;

    @Mock
    private LabelRepository mockLabelRepository;

    @InjectMocks
    private LabelService labelService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenReadLabelAndEqFields() {
        List<Label> expected = Arrays.asList(label(), label());
        when(mockLabelRepository.read()).thenReturn(Arrays.asList(label(), label()));

        List<Label> actual = labelService.read();
        verify(mockLabelRepository, times(1)).read();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).id(), actual.get(0).id());
        assertEquals(expected.get(0).name(), actual.get(0).name());
    }

    @Test
    public void whenUpdateLabel() {
        doNothing().when(mockLabelRepository).update(label);
        labelService.update(label);

        verify(mockLabelRepository, times(1)).update(label);
    }

    @Test
    public void whenDeleteLabel() {
        doNothing().when(mockLabelRepository).remove(label);
        labelService.delete(label);

        verify(mockLabelRepository, times(1)).remove(label);
    }

    private Label label() {
        return new Label(1, "Some name label");
    }
}