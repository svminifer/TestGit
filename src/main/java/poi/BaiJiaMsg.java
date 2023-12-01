package poi;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class BaiJiaMsg {

	private String id;

	private String ntitle;

	private String publish_time;

	private String publish_type;

	private String read_amount;

	private String comment_amount;

	private String like_amount;

	private String share_amount;

	private String collection_amount;

	private String quality_audit_type;

	private String quality_not_pass_reason;

	private String quality_status;

}
