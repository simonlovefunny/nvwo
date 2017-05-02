package com.simon.nvwo.excel;

import java.util.Collection;

/**
 * ���ڻ�����sheet��Vo The <code>ExcelSheet</code>
 * 
 * @author sargeras.wang
 * @version 1.0, Created at 2013��10��25��
 */
public class ExcelSheet<T> {
    private String sheetName;
    private String[] headers;
    private Collection<T> dataset;

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * Excelҳǩ����
     * 
     * @param sheetName
     *            the sheetName to set
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * Excel��ͷ
     * 
     * @return the headers
     */
    public String[] getHeaders() {
        return headers;
    }

    /**
     * @param headers
     *            the headers to set
     */
    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    /**
     * Excel���ݼ���
     * 
     * @return the dataset
     */
    public Collection<T> getDataset() {
        return dataset;
    }

    /**
     * @param dataset
     *            the dataset to set
     */
    public void setDataset(Collection<T> dataset) {
        this.dataset = dataset;
    }

}
