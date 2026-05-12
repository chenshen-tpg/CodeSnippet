import time
import redis
import redis_client


def allow_request(user_id):
    now = int(time.time())
    max_tokens = 100
    refill_rate = max_tokens / 60  # tokens per second
    script = open('token_bucket.lua').read()
    allowed = redis_client.eval(
        script, 1, f"rate_limit:{user_id}", max_tokens, refill_rate, now
    )
    return allowed == 1