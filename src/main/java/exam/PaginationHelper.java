package com.tiny.o2o.mytest;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {
    private int itemsPerPage;
    private int itemCount;
    private int pageCount;
    private int lastPageItemCount;

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        if(itemsPerPage <= 0)
        {
            throw new RuntimeException("itemsPerPage cannot lower than 1!");
        }
        this.itemsPerPage = itemsPerPage;
        this.itemCount = collection.size();
        this.pageCount = (int)Math.ceil(this.itemCount*1.0 / itemsPerPage);
        int tmp = this.itemCount % itemsPerPage;
        this.lastPageItemCount = tmp == 0 ? itemsPerPage: tmp;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        return this.itemCount;
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        return this.pageCount;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex < 0 || pageIndex >= this.pageCount)
        {
            return -1;
        }
        if(pageIndex == this.pageCount - 1)
        {
            return this.lastPageItemCount;
        }
        return this.itemsPerPage;
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0 || itemIndex >= this.itemCount)
        {
            return -1;
        }
        return itemIndex / this.itemsPerPage;
    }
}