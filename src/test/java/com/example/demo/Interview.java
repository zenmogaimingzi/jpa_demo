package com.example.demo;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 机试
 */
public class Interview {

    private static String IP_REGEX = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)$";

    public static void main(String[] args) {
        // 第一题
        System.out.println("第一题");
        List<String> ipList1 = getIpList(20, false);
        System.out.println("排序前：" + String.join(", ", ipList1));
        System.out.println("排序后：" + String.join(", ", sort(ipList1)));

        // 第二题
        System.out.println("\n第二题");
        List<String> ipList2 = getIpList(30, true);
        System.out.println("原列表：" + String.join(", ", ipList2));
        System.out.println("错误列表：" + String.join(", ", filter(ipList2)));
        System.out.println("正确列表：" + String.join(", ", ipList2));

        // 第三题
        System.out.println("\n第三题");
        List<String> ipList3 = getIpList(1000000, false);
        long start = System.currentTimeMillis();
        ipList3 = sort(ipList3);
        //提取前100项
        List<String> ipList100= new ArrayList();
        System.out.println("前一百项列表：" + String.join(", ", ipList100));
        long end = System.currentTimeMillis();
        System.out.println("排序耗时：" + (end - start) + "ms");
    }

    /**
     * 过滤，将错误IP剔除并返回
     * @param ipList 待过滤列表
     * @return 错误IP列表
     */
    private static List<String> filter(List<String> ipList) {
        Pattern isIP = Pattern.compile(IP_REGEX);
        List<String> resultList = new ArrayList<>();

        if (Objects.isNull(ipList)){
            return resultList;
        }

        for (String ipStr : ipList) {
            if (!isIP.matcher(ipStr).find()){
                resultList.add(ipStr);
            }
        }

        return resultList;
    }

    /**
     * 排序，IP分段从小到大排序
     * @param ipList 待排序列表
     * @return 正确排序列表
     */
    private static List<String> sort(List<String> ipList) {

        return ipList.stream().sorted((e1, e2) -> {

            StringTokenizer token = new StringTokenizer(e1, ".");
            StringTokenizer token2 = new StringTokenizer(e2, ".");
            while (token.hasMoreTokens() && token2.hasMoreTokens()) {
                int parseInt = Integer.parseInt(token.nextToken());
                int parseInt2 = Integer.parseInt(token2.nextToken());
                if (parseInt > parseInt2) {
                    return 1;
                }
                if (parseInt < parseInt2) {
                    return -1;
                }

            }
            if (token.hasMoreElements()) { // e1还有值，则e2已遍历完
                return 1;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());
    }



    /**
     * 构造机试题参数
     * @param num List元素个数
     * @param hasError 是否含有错误
     * @return IP列表
     */
    public static List<String> getIpList(Integer num, boolean hasError) {
        List<String> ipList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= num; i++) {
            StringBuilder str = new StringBuilder();
            for (int y = 1; y <= 4; y++) {
                if (str.length() > 0) {
                    str.append(".");
                }
                str.append(random.nextInt(256));
            }
            String ip = str.toString();
            if (hasError) {
                int confusion = random.nextInt(10);
                switch (confusion) {
                    case 1 : ip = String.valueOf(random.nextInt(256));break;
                    case 2 : ip = ip.replace(".",":");break;
                    case 3 : ip = ip + "." + random.nextInt(256);break;
                    case 4 : ip = random.nextInt(256) + 256 + str.substring(str.indexOf("."));break;
                    default:
                }
            }
            ipList.add(ip);
        }
        return ipList;
    }
}