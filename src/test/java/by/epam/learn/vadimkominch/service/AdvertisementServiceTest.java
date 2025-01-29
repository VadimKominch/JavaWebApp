package by.epam.learn.vadimkominch.service;

import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.repository.AdvertismentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdvertisementServiceTest {

    @Mock
    AdvertismentRepository adsRepository;

    @InjectMocks
    AdvertisementService service;

    @Test
    public void getEmptyListWhenNothingFound() {
        when(adsRepository.getFirstNAds(any())).thenReturn(List.of(new Advertisement()));
        var result = service.getTopN(4);
        Assertions.assertEquals(1, result.size());
    }
}
