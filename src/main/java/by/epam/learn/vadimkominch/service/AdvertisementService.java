package by.epam.learn.vadimkominch.service;

import by.epam.learn.vadimkominch.entity.AdvertisementApiModel;
import by.epam.learn.vadimkominch.entity.AdvertisementModel;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.repository.AdvertismentRepository;
import by.epam.learn.vadimkominch.entity.Page;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AdvertisementService {

    private final AdvertismentRepository adsRepository;
    private final UserService userService;

    public AdvertisementService() {
        this(AdvertismentRepository.getInstance(), UserService.getInstance());
    }

    protected AdvertisementService(AdvertismentRepository adsRepository, UserService userService) {
        this.adsRepository = adsRepository;
        this.userService = userService;
    }

    public Advertisement getAdvertisementById(int id) {
        return adsRepository.getOne(id);
    }

    public AdvertisementModel getAdvertisementWithFullInfoById(int id) {
        return adsRepository.getAdsWithCategoryAndUser(id);
    }

    public List<AdvertisementModel> getAdvertisementsWithFullInfoById(Page page) {
        return Collections.emptyList();
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

    public List<Advertisement> getCategoryAdvertisements(int categoryId) {
        return Collections.emptyList();
    }

    public void saveAdvertisement(AdvertisementApiModel adsModel, User user) {
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(adsModel.getTitle());
        advertisement.setBody(adsModel.getBody());
        advertisement.setCreatedDate(new Date());
        advertisement.setAuthorId(user.getId().getValue());
        advertisement.setCategoryId(adsModel.getCategoryId());
        adsRepository.save(advertisement);
    }

    public void updateAdvertisement(AdvertisementApiModel adsModel, User user) {
        Advertisement advertisement = adsRepository.getOne(adsModel.getAdsId());
        if(advertisement == null) {
            throw new IllegalStateException();
        }

        advertisement.setTitle(adsModel.getTitle());
        advertisement.setBody(adsModel.getBody());
        advertisement.setCategoryId(adsModel.getCategoryId());
        adsRepository.update(adsModel.getAdsId(), advertisement);
    }

    public void delete(Integer id) {
        Advertisement adsToDelete = adsRepository.getOne(id);
        if(adsToDelete != null) {
            adsRepository.delete(adsToDelete);
        }
    }

    private static class Holder {
        private static final AdvertisementService INSTANCE = new AdvertisementService();
    }

    public static AdvertisementService getInstance() {
        return AdvertisementService.Holder.INSTANCE;
    }
}
