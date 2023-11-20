package testmodelmapper.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Review")
@Data
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contentreview")
    private String contentReview;

    @Column(name = "reviewsao")
    private int reviewSao;
    @ManyToOne
    @JoinColumn(name = "product")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity user;

    @Column(name = "date")
    private Date date;

    @Column(name = "reviewstatus")
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
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

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
    
	
	
}
