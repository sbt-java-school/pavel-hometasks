package com.norg.representer;

import java.io.OutputStream;

/**
 * Created by Norg on 03.09.2016.
 */
public interface Representable {
    void represent(OutputStream outputStream) throws Exception;
}
