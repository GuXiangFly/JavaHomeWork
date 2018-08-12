package cn.guxiangfly.ebay.tingxian;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 7/30/18
 * @desc : JavaHomeWork
 */

public class JsonDomain {
   String errorId;
   String flowId;
   String external_ref_unique_id;
   String rrp_client_id;

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getExternal_ref_unique_id() {
        return external_ref_unique_id;
    }

    public void setExternal_ref_unique_id(String external_ref_unique_id) {
        this.external_ref_unique_id = external_ref_unique_id;
    }

    public String getRrp_client_id() {
        return rrp_client_id;
    }

    public void setRrp_client_id(String rrp_client_id) {
        this.rrp_client_id = rrp_client_id;
    }

    @Override
    public String toString() {
        return "JsonDomain{" +
                "errorId='" + errorId + '\'' +
                ", flowId='" + flowId + '\'' +
                ", external_ref_unique_id='" + external_ref_unique_id + '\'' +
                ", rrp_client_id='" + rrp_client_id + '\'' +
                '}';
    }
}
