/*
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2013 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.broadleafcommerce.core.rating.dao;

import org.broadleafcommerce.core.rating.domain.RatingDetail;
import org.broadleafcommerce.core.rating.domain.RatingSummary;
import org.broadleafcommerce.core.rating.domain.ReviewDetail;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.broadleafcommerce.profile.core.domain.Customer;

import java.util.Date;
import java.util.List;

public interface RatingSummaryDao {

    public RatingSummary createSummary();
    
    public RatingSummary createSummary(String itemId, RatingType type);
    
    public RatingDetail createDetail();
    
    public RatingDetail createDetail(RatingSummary ratingSummary, Double rating, Date submittedDate, Customer customer);
    
    RatingSummary readRatingSummary(String itemId, RatingType type);
    List<RatingSummary> readRatingSummaries(List<String> itemIds, RatingType type);
    RatingSummary saveRatingSummary(RatingSummary summary);
    void deleteRatingSummary(RatingSummary summary);

    RatingDetail readRating(Long customerId, Long ratingSummaryId);
    ReviewDetail readReview(Long customerId, Long ratingSummaryId);
}
