/**
 ** Copyright (c) 2010 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 **/

package com.ushahidi.android.app.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.ushahidi.android.app.models.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseListAdapter
 *
 * Base class for all list adapters for a specific BaseModel class
 *
 * @param <M> Model class
 */
public abstract class BaseListAdapter<M extends BaseModel> extends BaseAdapter {

    protected final Context context;
    protected final LayoutInflater inflater;
    protected final List<M> items = new ArrayList<M>();

    public BaseListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.items.size();
    }

    public void setItems(List<M> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    public M getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public int indexOf(M item) {
        return items.indexOf(item);
    }

    public abstract void refresh(Context context);

    protected void log(String message) {
        Log.i(getClass().getName(), message);
    }

    protected void log(String format, Object...args) {
        Log.i(getClass().getName(), String.format(format, args));
    }

    protected void log(String message, Exception ex) {
        Log.e(getClass().getName(), message, ex);
    }

}
