package com.hc.cn.config;
import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
/** 正式
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2017072007824345";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVUpUtsaM7/xDQv4k3W1M2XzhTLtEI7bXP0EcVjAz06Hhb6sYWHlHSS9he/fDM8qyPMcjgr+EaiYdTDlNVwjjouTWmDpHjxXPcPtI1mrYyk/xEz0bBVBPdD28ISDnZjiqRpU0VZdkO8U5KpcvBcIJ3pOgm5ytZPkx1ziNyVbEEawyUMNp8ifssbFZBr9xFUtfAYgFXAz0TbGwd3e/tYHVHO2UfyQMyfAxEjxhqSOxj5ltSKFQxybvc+zEPHoD0PoikUUKKFDOX/DHskKQMUEh6okbELVEShHyAfDlXNsA68B2Va7ytZfetOcnc4iYvr7JVulUtfP0wZ7gpch2EzDA5AgMBAAECggEAHG2dgxaHqjt0OxnMCOL1I6vbMFMAbv+6lnbjoaGJMfM0PuOilMFu+GeCKQuVlZ855QUoZkZ1x7SZM+HNUc1pQj1IjnXFpqSH202GfbgXqedsprkDknjsUzDGBcCiat3bEuFynHlIasTcD/Aiq5A89oRJwmZOZW4r5l25d+ICkoF4Sq+EWNnitcPs0BNitDXvG/7NwxrXAUfZAG9eV0odO0mDSX+EEyHyyHNndkgZi834PCu5MYO1tuyc52ajUN8yOsQ4/44L0gU/jIBMbnbYO5RvyiYSbSqFvC4HfD/ReQCW+nE9iuOW0tMznRTZYzn2nsV9vGqeF5ZxRsk1edBGlQKBgQDQM6EMdFA16eyJ2/g5LCkqOXqtUALctY9KIuElqubpOl2mlUcN5zwecBoPYKCh+RAI11ZeMjvZUHmwI6wc7O7TKBz/suoemakaLrmPDzQiTMni9adQMXyvemcmq2IGCrvkPaTZI5Dpmv0HK9PdvOmdPCgKk0v0w15ViS46bFwf0wKBgQC3moc/jJ84JVSYwQ7slKVksL25JAWQrvk3OyONfjvRqKRn6jTceYRLwIKULNAzhX/rzllJ3rURtMaHYez9eGpMQBkut5YurikKSXyz4g/YPnNvWKGbyH4GtIyyw/lgsYvwEsVur+kWEI3rdGAT4Vt0bkl2p+PgL7f5Pf7mqkM0QwKBgHDOmIL7/n3Huh7T7YFkuQUk0aBYCsT1JqcfkOfs2mIh+p4IodAZqsw/Jw+P5lj8bsCrlCNDioPrg5N5MIcXpSsJv/SXRxy/Ww1Rpb6qmS/AdV6ghUABIDKf2oXsNBdb94PqFoiEKb8498HL8GZjNhy4fGWGe5ApztH/mumSzrN7AoGAcNe5njY4OVLAPq4RFRh62nrB8EMSZI0VwHtJa5IVA9OpT/CjEopg5Anqd1VflPrM10nYmM0W7k3z4osuE87pTfnrQEo3NHN358moqgobgOVJHzsTAGLmCgr3mntWDrawchmnXFMjZ5s/DmJVFoLgKZwK7LFdHZFWego/Wtd0PG8CgYEAiw6CKfdZqCjRjdnWPgzzmlgI5/UYV3lDs3jSqS65z7wNB0zv1a8qzUx+hAvDlW8CF/dtWwyIQ9kPkpzHZeMkj+k1ELhfhhgffSVV4qOoz7w5TRcVNW3fsplk+B7z1E1xndvEJE7/GM51lfR3E9u9o55Ev5F7GHeQHN6QcyB0vCA=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlVKVLbGjO/8Q0L+JN1tTNl84Uy7RCO21z9BHFYwM9Oh4W+rGFh5R0kvYXv3wzPKsjzHI4K/hGomHUw5TVcI46Lk1pg6R48Vz3D7SNZq2MpP8RM9GwVQT3Q9vCEg52Y4qkaVNFWXZDvFOSqXLwXCCd6ToJucrWT5Mdc4jclWxBGsMlDDafIn7LGxWQa/cRVLXwGIBVwM9E2xsHd3v7WB1RztlH8kDMnwMRI8YakjsY+ZbUihUMcm73PsxDx6A9D6IpFFCihQzl/wx7JCkDFBIeqJGxC1REoR8gHw5VzbAOvAdlWu8rWX3rTnJ3OImL6+yVbpVLXz9MGe4KXIdhMwwOQIDAQAB";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	*/
	/** 沙箱*/
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016080300155484";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVUpUtsaM7/xDQv4k3W1M2XzhTLtEI7bXP0EcVjAz06Hhb6sYWHlHSS9he/fDM8qyPMcjgr+EaiYdTDlNVwjjouTWmDpHjxXPcPtI1mrYyk/xEz0bBVBPdD28ISDnZjiqRpU0VZdkO8U5KpcvBcIJ3pOgm5ytZPkx1ziNyVbEEawyUMNp8ifssbFZBr9xFUtfAYgFXAz0TbGwd3e/tYHVHO2UfyQMyfAxEjxhqSOxj5ltSKFQxybvc+zEPHoD0PoikUUKKFDOX/DHskKQMUEh6okbELVEShHyAfDlXNsA68B2Va7ytZfetOcnc4iYvr7JVulUtfP0wZ7gpch2EzDA5AgMBAAECggEAHG2dgxaHqjt0OxnMCOL1I6vbMFMAbv+6lnbjoaGJMfM0PuOilMFu+GeCKQuVlZ855QUoZkZ1x7SZM+HNUc1pQj1IjnXFpqSH202GfbgXqedsprkDknjsUzDGBcCiat3bEuFynHlIasTcD/Aiq5A89oRJwmZOZW4r5l25d+ICkoF4Sq+EWNnitcPs0BNitDXvG/7NwxrXAUfZAG9eV0odO0mDSX+EEyHyyHNndkgZi834PCu5MYO1tuyc52ajUN8yOsQ4/44L0gU/jIBMbnbYO5RvyiYSbSqFvC4HfD/ReQCW+nE9iuOW0tMznRTZYzn2nsV9vGqeF5ZxRsk1edBGlQKBgQDQM6EMdFA16eyJ2/g5LCkqOXqtUALctY9KIuElqubpOl2mlUcN5zwecBoPYKCh+RAI11ZeMjvZUHmwI6wc7O7TKBz/suoemakaLrmPDzQiTMni9adQMXyvemcmq2IGCrvkPaTZI5Dpmv0HK9PdvOmdPCgKk0v0w15ViS46bFwf0wKBgQC3moc/jJ84JVSYwQ7slKVksL25JAWQrvk3OyONfjvRqKRn6jTceYRLwIKULNAzhX/rzllJ3rURtMaHYez9eGpMQBkut5YurikKSXyz4g/YPnNvWKGbyH4GtIyyw/lgsYvwEsVur+kWEI3rdGAT4Vt0bkl2p+PgL7f5Pf7mqkM0QwKBgHDOmIL7/n3Huh7T7YFkuQUk0aBYCsT1JqcfkOfs2mIh+p4IodAZqsw/Jw+P5lj8bsCrlCNDioPrg5N5MIcXpSsJv/SXRxy/Ww1Rpb6qmS/AdV6ghUABIDKf2oXsNBdb94PqFoiEKb8498HL8GZjNhy4fGWGe5ApztH/mumSzrN7AoGAcNe5njY4OVLAPq4RFRh62nrB8EMSZI0VwHtJa5IVA9OpT/CjEopg5Anqd1VflPrM10nYmM0W7k3z4osuE87pTfnrQEo3NHN358moqgobgOVJHzsTAGLmCgr3mntWDrawchmnXFMjZ5s/DmJVFoLgKZwK7LFdHZFWego/Wtd0PG8CgYEAiw6CKfdZqCjRjdnWPgzzmlgI5/UYV3lDs3jSqS65z7wNB0zv1a8qzUx+hAvDlW8CF/dtWwyIQ9kPkpzHZeMkj+k1ELhfhhgffSVV4qOoz7w5TRcVNW3fsplk+B7z1E1xndvEJE7/GM51lfR3E9u9o55Ev5F7GHeQHN6QcyB0vCA=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlVKVLbGjO/8Q0L+JN1tTNl84Uy7RCO21z9BHFYwM9Oh4W+rGFh5R0kvYXv3wzPKsjzHI4K/hGomHUw5TVcI46Lk1pg6R48Vz3D7SNZq2MpP8RM9GwVQT3Q9vCEg52Y4qkaVNFWXZDvFOSqXLwXCCd6ToJucrWT5Mdc4jclWxBGsMlDDafIn7LGxWQa/cRVLXwGIBVwM9E2xsHd3v7WB1RztlH8kDMnwMRI8YakjsY+ZbUihUMcm73PsxDx6A9D6IpFFCihQzl/wx7JCkDFBIeqJGxC1REoR8gHw5VzbAOvAdlWu8rWX3rTnJ3OImL6+yVbpVLXz9MGe4KXIdhMwwOQIDAQAB";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	
	//==============================================================================沙箱结束 
	
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://20.77.216.48/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://20.77.216.48/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
	// 签名方式
	public static String sign_type = "RSA2";
	// 字符编码格式
		public static String charset = "utf-8";
	// 支付宝网关
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

