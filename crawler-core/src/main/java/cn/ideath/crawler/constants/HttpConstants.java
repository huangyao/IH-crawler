package cn.ideath.crawler.constants;

/**
 * HTTP常量
 * @author XunYu
 *
 */
public interface HttpConstants {

	// ------ STATUS ------ start
	public static final int STATUS_CONTINUE = 100;
	public static final int STATUS_SWITCHING_PROTOCOLS = 101;
	public static final int STATUS_PROCESSING = 102;

	public static final int STATUS_OK = 200;
	public static final int STATUS_CREATED = 201;
	public static final int STATUS_ACCEPTED = 202;
	public static final int STATUS_NON_AUTHORITATIVE_INFORMATION = 203;
	public static final int STATUS_NO_CONTENT = 204;
	public static final int STATUS_RESET_CONTENT = 205;
	public static final int STATUS_PARTIAL_CONTENT = 206;
	public static final int STATUS_MULTI_STATUS = 207;

	public static final int STATUS_MULTIPLE_CHOICES = 300;
	public static final int STATUS_MOVED_PERMANENTLY = 301;
	public static final int STATUS_MOVED_TEMPORARILY = 302;
	public static final int STATUS_SEE_OTHER = 303;
	public static final int STATUS_NOT_MODIFIED = 304;
	public static final int STATUS_USE_PROXY = 305;
	public static final int STATUS_TEMPORARY_REDIRECT = 307;

	public static final int STATUS_BAD_REQUEST = 400;
	public static final int STATUS_UNAUTHORIZED = 401;
	public static final int STATUS_PAYMENT_REQUIRED = 402;
	public static final int STATUS_FORBIDDEN = 403;
	public static final int STATUS_NOT_FOUND = 404;
	public static final int STATUS_METHOD_NOT_ALLOWED = 405;
	public static final int STATUS_NOT_ACCEPTABLE = 406;
	public static final int STATUS_PROXY_AUTHENTICATION_REQUIRED = 407;
	public static final int STATUS_REQUEST_TIMEOUT = 408;
	public static final int STATUS_CONFLICT = 409;
	public static final int STATUS_GONE = 410;
	public static final int STATUS_LENGTH_REQUIRED = 411;
	public static final int STATUS_PRECONDITION_FAILED = 412;
	public static final int STATUS_REQUEST_TOO_LONG = 413;
	public static final int STATUS_REQUEST_URI_TOO_LONG = 414;
	public static final int STATUS_UNSUPPORTED_MEDIA_TYPE = 415;
	public static final int STATUS_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
	public static final int STATUS_EXPECTATION_FAILED = 417;
	public static final int STATUS_INSUFFICIENT_SPACE_ON_RESOURCE = 419;
	public static final int STATUS_METHOD_FAILURE = 420;
	public static final int STATUS_UNPROCESSABLE_ENTITY = 422;
	public static final int STATUS_LOCKED = 423;
	public static final int STATUS_FAILED_DEPENDENCY = 424;

	public static final int STATUS_INTERNAL_SERVER_ERROR = 500;
	public static final int STATUS_NOT_IMPLEMENTED = 501;
	public static final int STATUS_BAD_GATEWAY = 502;
	public static final int STATUS_SERVICE_UNAVAILABLE = 503;
	public static final int STATUS_GATEWAY_TIMEOUT = 504;
	public static final int STATUS_HTTP_VERSION_NOT_SUPPORTED = 505;
	public static final int STATUS_INSUFFICIENT_STORAGE = 507;
	// ------ STATUS ------ end
	
	// ------ METHOD ------ start
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	// ------ METHOD ------ end
}
