package d1scodancer.usermicroservice.exceptions;

/**
 * @author Aleksey Shulikov
 */
public record ApiException(Integer code, String status, String message) {
}
