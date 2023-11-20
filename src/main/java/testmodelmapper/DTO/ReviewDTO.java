package testmodelmapper.DTO;

import java.util.Date;

import lombok.Data;
import testmodelmapper.Entity.UserEntity;

@Data
public class ReviewDTO {
	    private Long id;
	    private String contentReview;
	    private int reviewSao;
	    private Long product;
	    private Long user;
	    private Date date;
	    private boolean reviewStatus;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getContentReview() {
			return contentReview;
		}
		public void setContentReview(String contentReview) {
			this.contentReview = contentReview;
		}
		public int getReviewSao() {
			return reviewSao;
		}
		public void setReviewSao(int reviewSao) {
			this.reviewSao = reviewSao;
		}
		
		public Long getUser() {
			return user;
		}
		public void setUser(Long user) {
			this.user = user;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public boolean isReviewStatus() {
			return reviewStatus;
		}
		public void setReviewStatus(boolean reviewStatus) {
			this.reviewStatus = reviewStatus;
		}
		public Long getProduct() {
			return product;
		}
		public void setProduct(Long product) {
			this.product = product;
		}
	
	    
	    
}
