package by.epam.learn.vadimkominch.service;

import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.repository.AdvertismentRepository;
import by.epam.learn.vadimkominch.entity.Page;

import java.util.List;

public class AdvertisementService {

    private final AdvertismentRepository adsRepository;

    public AdvertisementService() {
        adsRepository = AdvertismentRepository.getInstance();
    }


    public List<Advertisement> getAdvertisementPage(Page page) {
        int lowBorder = page.getPageSize() * (page.getPageNumber() - 1) + 1;
        int highBorder = page.getPageSize() * page.getPageNumber();
        return adsRepository.getAdvertisementsInBorders(lowBorder,highBorder);
    }

    public List<Advertisement> getTopN(int n) {
        return adsRepository.getFirstNAds(n);
    }

    public List<Advertisement> getUserAdvertisements(int userId) {
        return adsRepository.getAdvertisementsForUser(userId);
    }

    private static class Holder {
        private static final AdvertisementService INSTANCE = new AdvertisementService();
    }

    public static AdvertisementService getInstance() {
        return AdvertisementService.Holder.INSTANCE;
    }
}
