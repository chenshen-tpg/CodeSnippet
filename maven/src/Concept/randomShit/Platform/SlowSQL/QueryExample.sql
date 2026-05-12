SELECT user_id, COUNT(*)
FROM user_activity
WHERE event_type = 'login'
  AND created_at >= '2024-01-01'
  AND created_at < '2024-02-01'
GROUP BY user_id
ORDER BY COUNT(*) DESC
    LIMIT 10;


CREATE INDEX idx_event_created ON user_activity(event_type, created_at);

CREATE INDEX idx_event_created_user ON user_activity(event_type, created_at, user_id);