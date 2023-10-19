import java.util.Date;

import cn.hutool.core.date.DateUtil;

/**
 * 在 childMavenProject 下新建 TestHutool类，并运行。
 * 可以发现，是可以使用 hutool jar 里的类的。 这说明子项目，能够使用 父项目中的 jar 包了。
 */
public class TestHutool {

    public static void main(String[] args) {
        String dateStr = "2012-12-12 12:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}