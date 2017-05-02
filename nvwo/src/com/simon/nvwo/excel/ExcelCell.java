package com.simon.nvwo.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

/**
 * The <code>ExcelCell</code><br>
 * ��ֵ�͵���λֻ��ʹ��Double
 * 
 * @see {@link com.sargeraswang.util.ExcelUtil.ExcelUtil#exportExcel}
 * @author ����
 * @version 1.0, Created at 2013��9��14��
 * @version 1.1, Updated at 2013��10��20�� ,�����ר������֤����ע��:Valid
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelCell {
    /**
     * ˳�� default 100
     * 
     * @return
     */
    public int index();

    /**
     * ��ֵΪnullʱҪ��ʾ��ֵ default StringUtils.EMPTY
     * 
     * @return
     */
    public String defaultValue() default StringUtils.EMPTY;

    /**
     * ������֤
     * 
     * @return
     */
    public Valid valid() default @Valid();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Valid {
        /**
         * ������in��String���,Ŀǰ��֧��String����
         * 
         * @return e.g. {"abc","123"}
         */
        public String[] in() default {};

        /**
         * �Ƿ�����Ϊ��,������֤���� default true
         * 
         * @return
         */
        public boolean allowNull() default true;

        /**
         * Apply a "greater than" constraint to the named property , equivalent ">"
         * 
         * @return
         */
        public double gt() default Double.NaN;

        /**
         * Apply a "less than" constraint to the named property , equivalent "<"
         * @return
         */
        public double lt() default Double.NaN;

        /**
         * Apply a "greater than or equal" constraint to the named property , equivalent ">="
         * 
         * @return
         */
        public double ge() default Double.NaN;

        /**
         * Apply a "less than or equal" constraint to the named property , equivalent "<="
         * 
         * @return
         */
        public double le() default Double.NaN;
    }
}
