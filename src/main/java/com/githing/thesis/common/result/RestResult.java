package com.githing.thesis.common.result;


import lombok.Data;

/**
 * Rest响应结果类
 *
 * @author githing <rdystwnts@126.com>
 * @date 2017/10/20
 */
@Data
public class RestResult<T> {

  private T resultData;
  private boolean success = true;
  private String message = "";
  private String code;

  public RestResult() {
    super();
  }

  public RestResult(T resultData) {
    this.resultData = resultData;
  }

  public RestResult(T resultData, boolean success, String message, String code) {
    this.resultData = resultData;
    this.success = success;
    this.message = message;
    this.code = code;
  }
}
