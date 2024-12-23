package by.epam.learn.vadimkominch.entity;

public class Page {

    private int pageSize;
    private int pageNumber;

    private static final int DEFAULT_PAGE_SIZE = 10;

    public Page(int pageSize, int pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public static Page of(int pageNumber) {
        return new Page(DEFAULT_PAGE_SIZE, pageNumber);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
