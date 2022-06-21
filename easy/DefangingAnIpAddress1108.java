package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/21 11:30
 */
public class DefangingAnIpAddress1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
